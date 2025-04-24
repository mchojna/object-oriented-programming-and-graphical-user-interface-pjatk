package mvcfx;

import javafx.event.*;					

public class Controller {
	
	private View view;
	private Model model;
	
	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void initView() {
		 view.getSumLabel().setText("" + model.getX());
	}

	public void initController() {
		
		view.getSumButtton().addEventHandler(
										/* event type */
									ActionEvent.ACTION , 	
										/* event handler/"listener" */
									(event) -> { 
													int newX = Integer.valueOf(view.getTextField().getText());
													model.setX(newX);
													view.getSumLabel().setText("" + model.getX());
											  }
		);
	
	
			// convenience method
		view.getClearButton().setOnAction(
									new EventHandler<ActionEvent>() {			
											
											@Override
											public void handle(ActionEvent event) {
												view.getTextField().setText("0");
												model.resetX();
												view.getSumLabel().setText("0");			
											}
									}
		);
	}
}
