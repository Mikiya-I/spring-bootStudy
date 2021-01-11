package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.login.domain.model.User;

@Mapper
public interface UserMapper {

	@Insert("insert into m_user("
			+"user_id,"
			+"password,"
			+ "user_name,"
			+ "birthday,"
			+ "age,"
			+ "marriage"
			+ "role)"
			+ "values("
			+ "#{userId},"
			+ "#{password},"
			+ "#{birthday},"
			+ "#{marriage},"
			+ "#{role})")
	public boolean insert(User user);


	@Select("select user_id as userId,"
			+ "password,"
			+ "user_name as userName,"
			+ "age,"
			+ "marriage,"
			+ "role"
			+ " from m_user"
			+ " where user_id = #{userId}")
	public User selectOne(String userId);


	@Select("select user_id as userId,"
			+ "password,"
			+ "user_name as userName,"
			+ "age,"
			+ "marriage,"
			+ "role"
			+ " from m_user")
	public List<User> selectMany();


	@Update("update m_user set"
			+ "password = #{password},"
			+ "user_name = #{userName},"
			+ "birthday = #{birthday}"
			+ "age = #{age},"
			+ "marriage =#{marriage}"
			+ " where user_id = #{userId}")
	public boolean updateOne(User user);


	@Delete("delete from m_user where user_id = #{userId}")
	public boolean deleteOne(String userId);



}
