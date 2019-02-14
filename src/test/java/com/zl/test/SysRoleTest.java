package com.zl.test;

import com.zl.config.Enabled;
import com.zl.entity.SysRole;
import com.zl.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author
 * @Description
 * @Date
 */
public class SysRoleTest extends BaseMapperTest {


    @Test
    public void testSelectAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = mapper.selectById(9L);
            System.err.println(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void insert() {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            System.out.println(new Date());
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("运维");
            sysRole.setCreateBy(1L);
            sysRole.setCreateTime(LocalDateTime.now());
            sysRole.setEnabled(Enabled.ENABLED);
            int insert = mapper.insert(sysRole);
            System.out.println(insert);
            System.out.println(sysRole);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
