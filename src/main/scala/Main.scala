import scala.io.StdIn.{readInt, readLine}

object Main {
  def encryption(text: String, shiftAmount: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        val encryptedChar = ((char - base + shiftAmount) % 26 + 26) % 26 + base
        encryptedChar.toChar
      } else {
        char
      }
    }
  }

  def decryption(text: String, shiftAmount: Int): String = {
    encryption(text, -shiftAmount)
  }

  def cipher(text: String, shiftAmount: Int, processF: (String, Int) => String): String = {
    processF(text, shiftAmount)
  }

  def main(args: Array[String]): Unit = {
    print("Enter your text   :- ")
    val text = readLine()
    print("Enter shiftAmount :- ")
    val shiftAmount = readInt()

    val encryptedText = cipher(text, shiftAmount, encryption)
    val decryptedText = cipher(encryptedText, shiftAmount, decryption)

    println("Your Text      :- " + text)
    println("Encrypted Text :- " + encryptedText)
    println("Decrypted Text :- " + decryptedText)
  }
}