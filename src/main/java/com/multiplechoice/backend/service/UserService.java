package com.multiplechoice.backend.service;

import java.util.List;

import com.multiplechoice.backend.entities.User;

public interface UserService {
	public int addUser(User user);

    public int deleteUser(Integer id);

    public int updateUser(User user);

    public User getUser(Integer id);

    public List<User> getUserList();
}
