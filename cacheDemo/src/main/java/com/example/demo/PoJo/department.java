package com.example.demo.PoJo;

/**
 * @author 袁毅
 * @date 2019/3/21 0021-下午 5:43
 */
public class department {

    Integer id;
    String departmentName;

    public department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
