package roles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AppointmentTest {
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
    void testGetinstaller() {
        assertNull(Appointment.getinstaller());
    }
}

