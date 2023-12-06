public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT OF TYPE D
		Type_A_GameObject A = new Type_A_GameObject(400, 0);
		A.setVelocity(10);
		canvas.addKeyListener(A);
		canvas.addGameObject(A);
		A.setHighlight(true);
		
		Type_B_GameObject B = new Type_B_GameObject(100, 300);
		D_B_Adapter Badapter = new D_B_Adapter(B);
		Badapter.setVelocity(10);
		canvas.addKeyListener(Badapter);
		canvas.addGameObject(Badapter);
		
		
		Type_C_GameObject C = new Type_C_GameObject(0, 400);
		C.setVelocity(7);
		canvas.addKeyListener(C);
		canvas.addGameObject(C);
		
		Type_D_GameObject user = new Type_D_GameObject(200, 200);
		user.setVelocity(5);
		canvas.addKeyListener(user);
		canvas.addGameObject(user);
		

	}

}

