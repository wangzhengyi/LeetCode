public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int areaA = (C - A) * (D - B);
		int areaB = (G - E) * (H - F);

		if (E > C || A > G || F > D || B > H) {
			return areaA + areaB;
		} else {

			int bx, by, tx, ty;
			bx = A > E ? A : E;
			by = B > F ? B : F;
			tx = C > G ? G : C;
			ty = D > H ? H : D;

			return areaA + areaB - (tx - bx) * (ty - by);
		}
	}

	public static void main(String[] args) {
		int area = new RectangleArea().computeArea(0, 0, 0, 0, -1, -1, 1, 1);
		System.out.println(area);
	}
}
