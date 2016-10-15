/**
 * 
 */
package com.multiplechoice.backend.dao;

import java.util.List;

import com.multiplechoice.backend.entities.User;

/**
 * @author Administrator
 *
 */
public interface UserDao {
	public int addUser(User user);

    public int deleteUser(Integer id);

    public int updateUser(User user);

    public User getUser(Integer id);

    public List<User> getUserList();
}
