/**
 * @author : Gathsara
 * created : 4/17/2023 -- 3:54 PM
 **/

package lk.ijse.hostel.pos.bo.custom.impl;

import lk.ijse.hostel.pos.bo.custom.UserBO;
import lk.ijse.hostel.pos.dao.DAOFactory;
import lk.ijse.hostel.pos.dao.custom.UserDAO;
import lk.ijse.hostel.pos.dto.UserDTO;
import lk.ijse.hostel.pos.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public ArrayList<UserDTO> getAllUser() throws SQLException, ClassNotFoundException {
        ArrayList<User> all = userDAO.getAll();
        ArrayList<UserDTO> user = new ArrayList<>();
        for (User user1 : all) {
            user.add(new UserDTO(user1.getUserName(), user1.getName(), user1.getAddress()
                    , user1.getContact_no(), user1.getPassword()));
        }
        return user;
    }

    @Override
    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getUserName(), dto.getName(), dto.getAddress(), dto.getContact_no(), dto.getPassword()));
    }

    @Override
    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(dto.getUserName(), dto.getName(), dto.getAddress(), dto.getContact_no(), dto.getPassword()));
    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        return userDAO.delete(id);
    }

    @Override
    public UserDTO searchUser(String id) throws SQLException, ClassNotFoundException {
        User search = userDAO.search(id);
        return new UserDTO(search.getUserName(), search.getName(), search.getAddress(), search.getContact_no(), search.getPassword());
    }

    @Override
    public boolean existUser(String id) throws SQLException, ClassNotFoundException {
        return existUser(id);
    }
}
