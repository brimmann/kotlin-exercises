import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Label
import java.awt.TextField
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField
import javax.swing.plaf.basic.BasicOptionPaneUI

fun main() {
    val mainWindow = JFrame("Capitalize")
    mainWindow.layout = FlowLayout()
    val userInput = JTextField()
    userInput.preferredSize = Dimension(100, 20)
    val convertButton = JButton("Convert")
    val displayLabel = Label()
    displayLabel.preferredSize = Dimension(100, 20)

    mainWindow.add(userInput)
    mainWindow.add(convertButton)
    mainWindow.add(displayLabel)
    mainWindow.pack()

    mainWindow.isVisible = true

    val buttonListener = object : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            displayLabel.text = userInput.text.toUpperCase()
            mainWindow.pack()
        }
    }
    convertButton.addActionListener(buttonListener)
}