public class SampleClass7-2ManyDefaultValues {
	
	public static Double GRAVITY = 9.8d;
	public static Double STATIONARY_SPEED = 0d;
	public static Double ZERO_BALL = 0d;
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double initialSpeed, Double acceleration, Double diameterOfBall) {
		return (FakeHelper.calculateDistanceTravelled(initialSpeed, acceleration) + diameterOfBall >= initialHeight);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double acceleration, Double diameterOfBall) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, acceleration, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double initialSpeed, Double diameterOfBall) {
		return doesBallHitTheGround(initialHeight, initialSpeed, GRAVITY, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double initialSpeed, Double acceleration) {
		return doesBallHitTheGround(initialHeight, initialSpeed, acceleration, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double diameterOfBall) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, GRAVITY, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double acceleration) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, acceleration, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight, Double initialSpeed) {
		return doesBallHitTheGround(initialHeight, initialSpeed, GRAVITY, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Double initialHeight) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, GRAVITY, ZERO_BALL);
	}
	
}