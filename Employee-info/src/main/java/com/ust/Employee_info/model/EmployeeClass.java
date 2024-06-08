package com.ust.Employee_info.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.ByteBuffer;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeClass {
    @Id
    @GeneratedValue
    private int empid;
    private String name;
    private String basicSalary;
    private String grade;

    @Override
    public String toString() {
        return "Employee{" +
                "empid='" + empid + '\'' +
                ", name='" + name + '\'' +
                ", basicSalary='" + basicSalary + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeClass employee = (EmployeeClass) o;
        return Objects.equals(empid, employee.empid);
    }


    public static int hashInteger(int input) {
        try {
            // Convert integer to byte array
            byte[] inputBytes = intToByteArray(input);

            // Hash the byte array using SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(inputBytes);

            // Convert the first 4 bytes of the hash to an integer
            return ByteBuffer.wrap(hashBytes).getInt();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    // Helper method to convert an integer to a byte array
    private static byte[] intToByteArray(int value) {
        return new byte[] {
                (byte) (value >> 24),
                (byte) (value >> 16),
                (byte) (value >> 8),
                (byte) value
        };
    }



}


