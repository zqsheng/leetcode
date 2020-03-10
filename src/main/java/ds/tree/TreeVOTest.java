package ds.tree;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.List;

public class TreeVOTest {
    @Data
    static class Dept implements Node<Long,String> {
        private Long id;
        private String name;
        private Long pid;
        private String code = "fds";

        public Dept(Long id, String name, Long pid) {
            this.id = id;
            this.name = name;
            this.pid = pid;
        }
    }

    @Data
    static class DeptTreeVO extends TreeVO<DeptTreeVO,Long,String> {

        /**
         * 是否授权
         */
        private boolean isAuthorized;

        private String code;

    }

    @Mapper
    interface DeptConverter {
        DeptConverter convert = Mappers.getMapper(DeptConverter.class);

        DeptTreeVO convertTreeVO(Dept dept);

    }
    public static void main(String[] args) {

        List<Dept> depts = new ArrayList<>();
        //1 level
        depts.add(new Dept(1L,"0-1",0L));
        depts.add(new Dept(2L,"0-2",0L));
        depts.add(new Dept(3L,"0-3",0L));

        //2 level
        depts.add(new Dept(4L,"1-1",1L));
        depts.add(new Dept(5L,"1-2",1L));
        depts.add(new Dept(6L,"1-3",1L));

        //3 level

        depts.add(new Dept(7L,"1-1-1",4L));
        depts.add(new Dept(8L,"1-1-2",4L));
        depts.add(new Dept(9L,"1-1-3",4L));

        List<DeptTreeVO> deptTreeVOS = TreeUtils.buildTreeVO(depts, 0L, (dept) -> DeptConverter.convert.convertTreeVO(dept));
        System.out.println(JSON.toJSONString(deptTreeVOS));
    }
}
