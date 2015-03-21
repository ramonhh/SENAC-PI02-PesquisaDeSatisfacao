/*
        Ele checa, no momento em que o usuário insere o caractere, se ele
        já não atingiu o limite. Se não, ele converte a string para 
        letras MAIÚSCULAS e insere no campo.

    Exemplos em http://www.programcreek.com/java-api-examples/index.php?api=javax.swing.text.DocumentFilter
                http://stackoverflow.com/questions/7527323/document-filter-is-not-working-in-java (dacwe)

*/

package Uteis;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Ramon Honorio
 */
public class FiltroCaracteres extends DocumentFilter {
    private final int max;
    private Component form;

    public FiltroCaracteres(int max, Component form) {
        this.max = max;
        this.form = form;
    }
    /*
            offset - valor da posição do último caractere (>=0)
            length - numero de caracteres a serem removidos (>=0)
            attrs - não entendemos muito bem o que faz
    */
    
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
                             String text, AttributeSet attr) 
            throws BadLocationException {
        if (fb.getDocument().getLength() + text.length() < max)
            super.insertString(fb, offset, text.toUpperCase(), attr);
        else 
            mostrarErro();
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset,
                        int length, String text, AttributeSet attrs)
            throws BadLocationException {
        int documentLength = fb.getDocument().getLength();
        if (documentLength - length + text.length() < max)
            super.replace(fb, offset, length, text.toUpperCase(), attrs);
        else 
            mostrarErro();
    }

    private void mostrarErro() {
        JOptionPane.showMessageDialog(form, "O limite de caracteres foi excedido. Tente resumir um pouco mais.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
