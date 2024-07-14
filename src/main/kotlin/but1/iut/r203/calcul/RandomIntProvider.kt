package but1.iut.r203.calcul
import kotlin.random.Random

class RandomIntProvider : IntProvider {
    override fun provideInt(): Int {
        return Random.nextInt()
    }
}