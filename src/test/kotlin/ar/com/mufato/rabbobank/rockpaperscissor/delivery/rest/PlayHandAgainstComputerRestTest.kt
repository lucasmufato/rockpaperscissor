package ar.com.mufato.rabbobank.rockpaperscissor.delivery.rest


import ar.com.mufato.rabbobank.rockpaperscissor.core.domain.HandShape
import ar.com.mufato.rabbobank.rockpaperscissor.core.services.ComputerHandService
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class PlayHandAgainstComputerRestTest{

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var computerHandService: ComputerHandService

    private lateinit var result: ResultActions

    @Test
    fun `play with a ROCK against PAPER`() {
        givenAComputerPlayingA(HandShape.PAPER)

        whenUserPlaysHandWith(ROCK_JSON)

        thenResultIs(status().isOk)
        thenResponseBodyIs(WIN_AGAINS_ROCK)
    }

    @Test
    fun `play with invalid option returns 400`() {
        givenAComputerPlayingA(HandShape.PAPER)

        whenUserPlaysHandWith(INVALID_JSON)

        thenResultIs(status().is4xxClientError)
        thenResponseBodyIs(EMPTY)
    }

    fun givenAComputerPlayingA(handShape: HandShape) {
        Mockito.`when`(computerHandService.obtainRandomHand()).thenReturn(handShape)
    }

    private fun whenUserPlaysHandWith(jsonContent: String) {
        val post = MockMvcRequestBuilders
            .post("/computer/play-hand")
            .content(jsonContent)
            .contentType(MediaType.APPLICATION_JSON)
        result = mockMvc.perform(post)
    }

    private fun thenResponseBodyIs(expectedBody: String) {
        result.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(expectedBody)))
    }

    private fun thenResultIs(resultMatcher: ResultMatcher) {
        result.andExpect(resultMatcher)
    }

    private companion object{
        const val WIN_AGAINS_ROCK = """{"result":"LOSE","opposing_hand":"PAPER"}"""
        const val ROCK_JSON = """{"hand_shape": "rock"}"""
        const val INVALID_JSON = """{"hand_shape": "random rubish"}"""
        const val EMPTY = ""
    }
}