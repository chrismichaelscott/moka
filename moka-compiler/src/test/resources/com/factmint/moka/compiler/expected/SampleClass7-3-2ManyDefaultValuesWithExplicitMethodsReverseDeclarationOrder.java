public class SampleClass7-3-2ManyDefaultValuesWithExplicitMethodsReverseDeclarationOrder {
	
	public static Double GRAVITY = 9.8d;
	public static Double STATIONARY_SPEED = 0d;
	public static Double ZERO_BALL = 0d;
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double initialSpeed, Double diameterOfBall) {
		return doesBallHitTheGround(initialHeight, initialSpeed, getAcceleration(), diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double initialSpeed, Double acceleration, Double diameterOfBall) {
		return (FakeHelper.calculateDistanceTravelled(initialSpeed, acceleration) + diameterOfBall >= initialHeight);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double initialSpeed) {
		return doesBallHitTheGround(initialHeight, initialSpeed, GRAVITY, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, GRAVITY, ZERO_BALL);
	}
	
}