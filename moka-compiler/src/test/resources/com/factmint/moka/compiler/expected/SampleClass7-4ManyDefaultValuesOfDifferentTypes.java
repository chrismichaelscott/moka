public class SampleClass7-4ManyDefaultValuesOfDifferentTypes {
	
	public static Float GRAVITY = 9.8f;
	public static Double STATIONARY_SPEED = 0d;
	public static Integer ZERO_BALL = 0;
	public static Double STARTING_HEIGHT = 100d;
	
	public Boolean doesBallHitTheGround(Float initialHeight, Double initialSpeed, Float acceleration, Integer diameterOfBall) {
		return (FakeHelper.calculateDistanceTravelled(initialSpeed, acceleration) + diameterOfBall >= initialHeight);
	}
	
	public Boolean doesBallHitTheGround(Float initialHeight, Double initialSpeed, Float acceleration) {
		return doesBallHitTheGround(initialHeight, initialSpeed, acceleration, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Float initialHeight, Double initialSpeed, Integer diameterOfBall) {
		return doesBallHitTheGround(initialHeight, initialSpeed, GRAVITY, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Float initialHeight, Float acceleration, Integer diameterOfBall) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, acceleration, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Double initialSpeed, Float acceleration, Integer diameterOfBall) {
		return doesBallHitTheGround(STARTING_HEIGHT, initialSpeed, acceleration, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Float initialHeight, Double initialSpeed) {
		return doesBallHitTheGround(initialHeight, initialSpeed, GRAVITY, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Float initialHeight, Float acceleration) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, acceleration, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Double initialSpeed, Float acceleration) {
		return doesBallHitTheGround(STARTING_HEIGHT, initialSpeed, acceleration, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Float initialHeight, Integer diameterOfBall) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, GRAVITY, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Double initialSpeed, Integer diameterOfBall) {
		return doesBallHitTheGround(STARTING_HEIGHT, initialSpeed, GRAVITY, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround(Float initialHeight) {
		return doesBallHitTheGround(initialHeight, STATIONARY_SPEED, GRAVITY, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Double initialSpeed) {
		return doesBallHitTheGround(STARTING_HEIGHT, initialSpeed, GRAVITY, ZERO_BALL);
	}
	
	public Boolean doesBallHitTheGround(Integer diameterOfBall) {
		return doesBallHitTheGround(STARTING_HEIGHT, STATIONARY_SPEED, GRAVITY, diameterOfBall);
	}
	
	public Boolean doesBallHitTheGround() {
		return doesBallHitTheGround(STARTING_HEIGHT, STATIONARY_SPEED, GRAVITY, ZERO_BALL);
	}
	
}