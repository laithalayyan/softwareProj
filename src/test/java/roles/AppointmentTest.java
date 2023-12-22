package roles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AppointmentTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Appointment#Appointment(String, String, String, String)}
     *   <li>{@link Appointment#setInstaller(Installer)}
     * </ul>
     */
    @Test
    void testConstructor() {
        Appointment actualAppointment = new Appointment("Customer Name", "2020-03-01", "Car Moder", "2020-03-01");
        actualAppointment.setInstaller(Appointment.getinstaller());
        assertEquals("2020-03-01", actualAppointment.getAppointmentDate());
        assertFalse(Appointment.isChooseSchedule);
        assertEquals("Customer Name", actualAppointment.getCustomerName());
        assertEquals("Car Moder", actualAppointment.getCustomerCarModel());
        assertEquals("2020-03-01", actualAppointment.getCustomerCarDate());
        assertEquals(0, actualAppointment.getAppointmentId());
    }


    @Test
    void testScheduleAppointment() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

       // Appointment.scheduleAppointment("Carmodel", "2020-03-01", 1);
    }




    /**
     * Method under test: {@link Appointment#getinstaller()}
     */
    @Test
    void testGetinstaller() {
        assertNull(Appointment.getinstaller());
    }
}

