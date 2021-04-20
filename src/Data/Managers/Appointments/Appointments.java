
package Data.Managers.Appointments;

public class Appointments {
    private static AppointmentsManager uniqueInstance;

    private Appointments(){};

    public static AppointmentsManager getInstance(){
        if(uniqueInstance == null){
            AppointmentsManager appointmentManager = new AppointmentsManager();
            uniqueInstance = appointmentManager;
        }
        return uniqueInstance;
    }
}
