package lk.ijse.Library_Management_System.BO.Custom;

import lk.ijse.Library_Management_System.BO.SuperBO;

public interface QueryBO extends SuperBO {
    int getAllOverdueBookCount();
}
