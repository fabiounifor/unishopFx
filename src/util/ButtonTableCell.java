package util;


import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.util.Callback;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio
 */
public class ButtonTableCell<S,T> extends TableCell<S,T> {
	
	private Button button;
	
	public ButtonTableCell(final Callback<Integer, Void> pressedCallback) {
		this(pressedCallback, null, null);
	}
	
	public ButtonTableCell(final Callback<Integer, Void> pressedCallback, String buttonText, Node buttonGraphic) {
		this.button = new Button(buttonText, buttonGraphic);
		this.button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pressedCallback.call(getTableRow().getIndex());
			}
		});
	}
	
	@Override
	protected void updateItem(T item, boolean empty) {
		super.updateItem(item, empty);
		if(empty) {
			setGraphic(null);
		} else {
			setGraphic(button);
			button.disableProperty().bind(Bindings.not(
                    getTableView().editableProperty().and(
                    getTableColumn().editableProperty()).and(
                    editableProperty())
                ));
		}
	}
}
