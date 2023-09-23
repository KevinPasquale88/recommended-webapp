package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.Emotions;
import it.sysagent.recommended.recommendedwebapp.entity.EmotionsEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryEmotions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmotionServiceTest {

    private final RepositoryEmotions repositoryEmotions = Mockito.mock(RepositoryEmotions.class);
    private final EmotionsService emotionsService = Mockito.spy(new EmotionsService(repositoryEmotions));

    private static Stream<Arguments> scenario_EmotionServiceTest_testGetEmotions() {
        return Stream.of(Arguments.of(Collections.emptyList()), Arguments.of(List.of(new EmotionsEntity(1L, "emotion"))));
    }

    @ParameterizedTest(name = "Test getEmotions")
    @MethodSource("scenario_EmotionServiceTest_testGetEmotions")
    public void testGetEmotions(List<EmotionsEntity> list) {
        Mockito.doReturn(list).when(repositoryEmotions).findAll();

        List<Emotions> emotions = emotionsService.getEmotions();
        assertEquals(emotions.size(), list.size());

        Mockito.verify(repositoryEmotions, Mockito.times(1)).findAll();
    }
}
