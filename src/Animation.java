public class Animation implements Action{
    private final AnimatedNotMovingEntity entity;

    private final int repeatCount;

    public Animation(
            AnimatedNotMovingEntity entity,
            int repeatCount)
    {
        this.entity = entity;

        this.repeatCount = repeatCount;
    }


    public void executeAction(
            EventScheduler scheduler)
    {
        this.entity.nextImage();

        if (this.repeatCount != 1) {
            EventScheduler.scheduleEvent(scheduler, this.entity,
                    Factory.createAnimationAction(this.entity,
                            Math.max(this.repeatCount - 1,
                                    0)),
                    this.entity.getAnimationPeriod());
        }
    }
}
