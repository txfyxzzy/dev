
class Denominator
{
	public static void main(String[] args) {
			int condition = 1000000;
			int denominator = 999983; // prime number
            String s = "990001199450230"; //DeviceInfoUtils.getIMEI(mAppContext);
            try {
                if (s.length() > 5) {
                    s = s.substring(s.length() - 5, s.length());
                }
                System.out.println("s: " + s);
                denominator = Integer.valueOf(s, 16);
                System.out.println("denominator: " + denominator);
            } catch (Exception e) {
            }

            boolean forced = (denominator % condition) == 0;
            System.out.println("forced: " + forced);
	}
}

