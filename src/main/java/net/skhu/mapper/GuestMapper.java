package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Guest;
import net.skhu.model.Pagination;

@Mapper
public interface GuestMapper {

	List<Guest> findAll(Pagination pagination);

	@Select("SELECT * FROM guestbook")
	Guest findById(int id);

	@Select("SELECT COUNT(id) FROM guestbook")
	int count();

//	@Select("SELECT * " + "FROM guestbook "+"ORDER BY id DESC")
//	List<Guest> findAll();

	@Insert("INSERT guestbook (name, content) "
			+ "VALUES ( #{name}, #{content})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Guest guest);
}