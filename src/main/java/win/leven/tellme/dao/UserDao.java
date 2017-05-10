package win.leven.tellme.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import win.leven.tellme.entity.UserEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by leven on 2017/4/12.
 */

@Repository
public class UserDao {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public List<UserEntity> findUserList() {
        return sqlSessionTemplate.selectList("UserMapper.findUserList");
    }
}
