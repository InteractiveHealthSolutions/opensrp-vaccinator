package org.ei.drishti.service;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.ei.drishti.domain.TimelineEvent;
import org.ei.drishti.domain.form.FormSubmission;
import org.ei.drishti.repository.EligibleCoupleRepository;
import org.ei.drishti.repository.TimelineEventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.ei.drishti.util.EasyMap.mapOf;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RobolectricTestRunner.class)
public class EligibleCoupleServiceTest {
    @Mock
    private EligibleCoupleRepository eligibleCoupleRepository;
    @Mock
    private TimelineEventRepository timelineEventRepository;

    private EligibleCoupleService service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        service = new EligibleCoupleService(eligibleCoupleRepository, timelineEventRepository);
    }

    @Test
    public void shouldCreateTimelineEventWhenECIsRegistered() throws Exception {
        FormSubmission submission = mock(FormSubmission.class);
        when(submission.entityId()).thenReturn("entity id 1");
        when(submission.getFieldValue("submissionDate")).thenReturn("2012-01-01");

        service.register(submission);

        verify(timelineEventRepository).add(TimelineEvent.forECRegistered("entity id 1", "2012-01-01"));
    }

    @Test
    public void shouldCloseEC() throws Exception {
        FormSubmission submission = mock(FormSubmission.class);
        when(submission.entityId()).thenReturn("entity id 1");
        when(submission.getFieldValue("submissionDate")).thenReturn("2012-01-01");

        service.closeEligibleCouple(submission);

        verify(eligibleCoupleRepository).close("entity id 1");
        verify(timelineEventRepository).deleteAllTimelineEventsForCase("entity id 1");
    }

    @Test
    public void shouldNotCreateTimelineEventWhenECIsRegisteredWithoutSubmissionDate() throws Exception {
        FormSubmission submission = mock(FormSubmission.class);
        when(submission.entityId()).thenReturn("entity id 1");
        when(submission.getFieldValue("submissionDate")).thenReturn(null);

        service.register(submission);

        verifyZeroInteractions(timelineEventRepository);
    }

    @Test
    public void shouldCreateTimelineEventAndUpdateEntityWhenFPChangeIsReported() throws Exception {
        FormSubmission submission = mock(FormSubmission.class);
        when(submission.entityId()).thenReturn("entity id 1");
        when(submission.getFieldValue("currentMethod")).thenReturn("condom");
        when(submission.getFieldValue("newMethod")).thenReturn("ocp");
        when(submission.getFieldValue("familyPlanningMethodChangeDate")).thenReturn("2012-01-01");

        service.fpChange(submission);

        verify(timelineEventRepository).add(TimelineEvent.forChangeOfFPMethod("entity id 1", "condom", "ocp", "2012-01-01"));
        verify(eligibleCoupleRepository).mergeDetails("entity id 1", mapOf("currentMethod", "ocp"));
    }
}
