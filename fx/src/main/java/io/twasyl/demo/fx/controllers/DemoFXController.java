package io.twasyl.demo.fx.controllers;

import io.twasyl.demo.core.Generator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TitledPaneSkin;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Thierry Wasylczenko
 * @version 1.0
 */
public class DemoFXController implements Initializable {

    @FXML private CheckBox allowNumbers;
    @FXML private CheckBox allowLowerCaseLetters;
    @FXML private CheckBox allowUpperCaseLetters;
    @FXML private TextField length;
    @FXML private Text generatedPasswordText;

    private final StringProperty generatedPassword = new SimpleStringProperty();

    private Generator generator;

    @FXML
    private void exitApplication(final ActionEvent event) {
        System.exit(0);
    }

    @FXML private void allowNumbersAction(final ActionEvent event) {
        this.generator.setNumberAllowed(this.allowNumbers.isSelected());
    }

    @FXML private void allowLowerCaseLettersAction(final ActionEvent event) {
        this.generator.setLowerCaseAllowed(this.allowLowerCaseLetters.isSelected());
    }

    @FXML private void allowUpperCaseLettersAction(final ActionEvent event) {
        this.generator.setUpperCaseAllowed(this.allowUpperCaseLetters.isSelected());
    }

    @FXML private void generatePasswordAction(final ActionEvent event) {
        this.generator.setLength(Integer.parseInt(this.length.getText()));
        final String password = this.generator.generate();

        this.generatedPasswordText.setText(password);
        this.generatedPassword.set(password);
    }

    @FXML private void copyGeneratedPasswordToClipboardAction(final ActionEvent event) {
        if(this.generatedPassword.isNotEmpty().get()) {
            final ClipboardContent content = new ClipboardContent();
            content.putString(this.generatedPassword.get());

            Clipboard.getSystemClipboard().setContent(content);
        }
    }

    @FXML private void clearPasswordAction(final ActionEvent event) {
        this.generatedPasswordText.setText("");
        this.generatedPassword.set("");
    }

    public String getGeneratedPassword() { return generatedPassword.get(); }

    public StringProperty generatedPasswordProperty() { return generatedPassword; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGenerator();
    }

    private void initializeGenerator() {
        this.generator = new Generator();
        this.generator.setNumberAllowed(this.allowNumbers.isSelected());
        this.generator.setLowerCaseAllowed(this.allowLowerCaseLetters.isSelected());
        this.generator.setUpperCaseAllowed(this.allowUpperCaseLetters.isSelected());
    }
}
