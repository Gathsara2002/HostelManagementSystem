/**
 * @author : Gathsara
 * created : 4/15/2023 -- 3:50 PM
 **/

package lk.ijse.hostel.pos.bo;

import lk.ijse.hostel.pos.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BOTypes types) {

        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case USER:
                return new UserBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            case QUERY:
                return new FindRemainKeyMoneyBOImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        ROOM, STUDENT, RESERVATION, USER,QUERY
    }
}
