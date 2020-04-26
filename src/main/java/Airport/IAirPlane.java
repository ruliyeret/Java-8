package Airport;

public interface IAirPlane {

    public void TakeOff();
    public void landing();
    public void flight();

    public void TakeOffSync();
    public void landingSync();
    public void flightSync();
}
