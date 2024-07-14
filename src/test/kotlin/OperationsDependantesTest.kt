import but1.iut.r203.calcul.IntProvider
import but1.iut.r203.calcul.OperationsDependantes
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class OperationsDependantesTest {

    val randomIntProvider = mockk<IntProvider>()
    val operationsDependantes = OperationsDependantes(randomIntProvider)

    @Test
    fun `test factorielleConsole with valid input`() {
        every { randomIntProvider.provideInt() } returns 5
        val resultFact = operationsDependantes.factorielleConsole()
        assertEquals(120, resultFact) }

    @Test
    fun `test diviserNaturelConsole with valid inputs`() {
        every { randomIntProvider.provideInt() } returnsMany listOf(10, 2)
        val result = operationsDependantes.diviserNaturelConsole()
        assertEquals(5.0f, result) }

    @Test
    fun `test factorielleConsole with zero input`() {
        every { randomIntProvider.provideInt() } returns 0
        val resultFact = operationsDependantes.factorielleConsole()
        assertEquals(1, resultFact)}

    @Test
    fun `test diviserNaturelConsole with zero divisor`() {
        every { randomIntProvider.provideInt() } returnsMany listOf(10, 0)
        assertThrows(ArithmeticException::class.java) { operationsDependantes.diviserNaturelConsole() } }

    @Test
    fun `test factorielleConsole with negative input`() {
        every { randomIntProvider.provideInt() } returns -5
        assertThrows(IllegalArgumentException::class.java) {operationsDependantes.factorielleConsole() } }

    @Test
    fun `test diviserNaturelConsole with negative numbers`() {
        every { randomIntProvider.provideInt() } returnsMany listOf(-10, 2)
        assertThrows(ArithmeticException::class.java) { operationsDependantes.diviserNaturelConsole() } }
}