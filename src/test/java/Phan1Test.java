import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Phan1Test {

    private final Phan1 phan1 = new Phan1();

//    kiểm tra số nguyên dương từ 1-100

    // HỢP LỆ
    // Biên Dưới
    @Test
    void testKiemTraSoDuong_BienDuoi_GiaTriBien() {
        assertTrue(phan1.kiemTraSoDuongTu1Den100(1), "Test 1: Số 1 phải hợp lệ (Biên dưới).");
    }



    // Cận biên Dưới
    @Test
    void testKiemTraSoDuong_BienDuoi_TrongBien() {
        assertTrue(phan1.kiemTraSoDuongTu1Den100(2), "Test 3: Số 2 phải hợp lệ (Ngay trên biên).");
    }

    // Biên Trên
    @Test
    void testKiemTraSoDuong_BienTren_GiaTriBien() {
        assertTrue(phan1.kiemTraSoDuongTu1Den100(100), "Test 4: Số 100 phải hợp lệ (Biên trên).");
    }

    // Cận biên Trên
    @Test
    void testKiemTraSoDuong_BienTren_TrongBien() {
        assertTrue(phan1.kiemTraSoDuongTu1Den100(99), "Test 6: Số 99 phải hợp lệ (Ngay dưới biên).");
    }


    // KHÔNG HỢP LỆ
    // Cận biên Dưới
    @Test
    void testKiemTraSoDuong_BienDuoi_NgoaiBien() {
        assertFalse(phan1.kiemTraSoDuongTu1Den100(0), "Test 2: Số 0 phải không hợp lệ (Ngay dưới biên).");
    }

    // Cận biên Trên
    @Test
    void testKiemTraSoDuong_BienTren_NgoaiBien() {
        assertFalse(phan1.kiemTraSoDuongTu1Den100(101), "Test 5: Số 101 phải không hợp lệ (Ngay trên biên).");
    }
}