package com.example.demoWDF.demo.service;

import com.example.demoWDF.demo.dto.ResponseData;
import com.example.demoWDF.demo.entity.employee;
import com.example.demoWDF.demo.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    employeeRepository employeeRepository;

    @Override
    public ResponseData addEmployee(employee employee) {
        try{
            if (employee.getEmployeeId().isEmpty() || employee.getEmployeeId().isBlank()){
                return new ResponseData(400, "Vui lòng nhập mã nhân viên",null);
            }else if(employee.getEmployeeId().length() > 20){
                return new ResponseData(400, "Vui lòng nhập mã nhân viên dưới 20 ký tự",null);
            }
            if (employee.getEmployeeName().isEmpty() || employee.getEmployeeName().isBlank()){
                return new ResponseData(400, "Vui lòng nhập tên nhân viên",null);
            }else if(employee.getEmployeeId().length() > 255){
                return new ResponseData(400, "Vui lòng nhập tên nhân viên dưới 255 ký tự",null);
            }
            if (employee.getBirthday() == null){
                return new ResponseData(400, "Vui lòng nhập ngày sinh nhân viên",null);
            }
            if (employee.getEmail().isEmpty() || employee.getEmail().isBlank()){
                return new ResponseData(400, "Vui lòng nhập email nhân viên",null);
            }else if(employee.getEmployeeId().length() > 255){
                return new ResponseData(400, "Vui lòng nhập email nhân viên dưới 255 ký tự",null);
            }

            if (employee.getPhoneNumber().isEmpty() || employee.getPhoneNumber().isBlank()){
                return new ResponseData(400, "Vui lòng nhập số điện thoại nhân viên",null);
            }else if(employee.getEmployeeId().length() > 11){
                return new ResponseData(400, "Vui lòng nhập sđt nhân viên dưới 11 ký tự",null);
            }

            employeeRepository.save(employee);
            return new ResponseData(200, "Thêm thành công nhân viên "+employee.getEmployeeName(),null);
        }catch (Exception e){
            return new ResponseData(500, e.getMessage(),e);
        }

    }

    @Override
    public ResponseData deleteEmployee(String id) {
        Optional<employee> find = employeeRepository.findById(id);
        if (find.isPresent()){
            employeeRepository.delete(find.get());
            return  new ResponseData(200 ,"Xóa thành công.",find);
        }else {
            return  new ResponseData(404 ,"Nhân viên không tồn tại.",null);
        }
    }

    @Override
    public ResponseData updateEmployee(String id,employee employee) {
        try{
            if (employee.getEmployeeId().isEmpty() || employee.getEmployeeId().isBlank()){
                return new ResponseData(400, "Vui lòng nhập mã nhân viên",null);
            }else if(employee.getEmployeeId().length() > 20){
                return new ResponseData(400, "Vui lòng nhập mã nhân viên dưới 20 ký tự",null);
            }
            if (employee.getEmployeeName().isEmpty() || employee.getEmployeeName().isBlank()){
                return new ResponseData(400, "Vui lòng nhập tên nhân viên",null);
            }else if(employee.getEmployeeId().length() > 255){
                return new ResponseData(400, "Vui lòng nhập tên nhân viên dưới 255 ký tự",null);
            }
            if (employee.getBirthday() == null){
                return new ResponseData(400, "Vui lòng nhập ngày sinh nhân viên",null);
            }
            if (employee.getEmail().isEmpty() || employee.getEmail().isBlank()){
                return new ResponseData(400, "Vui lòng nhập email nhân viên",null);
            }else if(employee.getEmployeeId().length() > 255){
                return new ResponseData(400, "Vui lòng nhập email nhân viên dưới 255 ký tự",null);
            }

            if (employee.getPhoneNumber().isEmpty() || employee.getPhoneNumber().isBlank()){
                return new ResponseData(400, "Vui lòng nhập số điện thoại nhân viên",null);
            }else if(employee.getEmployeeId().length() > 11){
                return new ResponseData(400, "Vui lòng nhập sđt nhân viên dưới 11 ký tự",null);
            }

            Optional<employee> employee1 = employeeRepository.findById(id);
            if (employee1.isPresent()){
                employee1.get().setEmployeeId(employee.getEmployeeId());
                employee1.get().setEmployeeName(employee.getEmployeeName());
                employee1.get().setBirthday(employee.getBirthday());
                employee1.get().setEmail(employee.getEmail());
                employee1.get().setPhoneNumber(employee.getPhoneNumber());
                employeeRepository.save(employee1.get());
                return new ResponseData(200, "Sửa thành công nhân viên "+employee.getEmployeeName(),null);
            }else {
                return new ResponseData(404, "Không tìm thấy nhân viên "+employee.getEmployeeName(),null);

            }



        }catch (Exception e){
            return new ResponseData(500, "Đã xảy ra lỗi !",e);

        }
    }

    @Override
    public List<employee> findEmployeeByNameOrId(String name, String id) {
        return employeeRepository.findByEmployeeNameOrEmployeeId(name,id);
    }

    @Override
    public List<employee> findAll() {
        return employeeRepository.findAll();
    }
}
