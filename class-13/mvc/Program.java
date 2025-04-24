package mvc;

public class Program {

	public static void main(String[] args) 
	{
		Model model = new Model(2024);
		View view = new View();
		
		Controller controller = new Controller(model, view);

		controller.initView();
		controller.initController();
	}
}