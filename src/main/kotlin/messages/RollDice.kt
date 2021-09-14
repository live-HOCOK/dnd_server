package messages

class RollDice {
    var value: Int = 0

    fun setValue(){
        value = (0..value).random()
    }
}