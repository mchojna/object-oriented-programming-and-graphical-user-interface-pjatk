package mvc;

public class Controller {
	
	private View view;
	private Model model;
	
	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void initView() {
		 view.getLabel().setText(""+model.getX());
	}

	public void initController() {
		
		view.getButton().addActionListener(e -> 
			{
				int newX = Integer.valueOf(view.getTextField().getText());
				model.setX(newX);
				view.getLabel().setText(""+model.getX());
			}
		);
		
	}
}
