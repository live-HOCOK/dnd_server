package messages

class RollDice {
    var value: Int = 0

    fun SetValue(){
        value = (0..value).random()
    }
}