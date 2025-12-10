import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SachServiceTest {

    private final SachService sachService = new SachService();

    private Sach createValidSach(int namXuatBan) {
        return new Sach("MS001", "Tên Sách Valid", "Tác Giả Valid", namXuatBan, 99.99f);
    }

    // namXuatBan(1990-2025).

    // Hợp lệ
    // Biên Dưới
    @Test
    void testSuaSach_BienDuoi_GiaTriBien() {
        Sach sach = createValidSach(1990);
        assertTrue(sachService.suaSach(sach), "TC 1: Năm 1990 => true");
    }

    // Cân biên Dưới
    @Test
    void testSuaSach_BienDuoi_GiaTriTrongBien() {
        Sach sach = createValidSach(1991);
        assertTrue(sachService.suaSach(sach), "TC 2: Năm 1991 => true");
    }

    // Biên Trên
    @Test
    void testSuaSach_BienTren_GiaTriBien() {
        Sach sach = createValidSach(2025);
        assertTrue(sachService.suaSach(sach), "TC 3: Năm 2025 => true");
    }



    // Cận biên Trên
    @Test
    void testSuaSach_BienTren_GiaTriTrongBien() {
        Sach sach = createValidSach(2024);
        assertTrue(sachService.suaSach(sach), "TC 4: Năm 2024 => true");
    }


    // KHÔNG HỢP LỆ
    // Cận biên Dưới
    @Test
    void testSuaSach_BienDuoi_GiaTriNgoaiBien() {
        Sach sach = createValidSach(1989);
        assertFalse(sachService.suaSach(sach), "TC 5: Năm 1989 => false");
    }

    // Cận biên trên
    @Test
    void testSuaSach_BienTren_GiaTriNgoaiBien() {
        Sach sach = createValidSach(2026);
        assertFalse(sachService.suaSach(sach), "TC 6: Năm 2026 => false");
    }



    // Validate trống
    @Test
    void testSuaSach_TacGiaTrong_KhongHopLe() {
        Sach sach = createValidSach(2000);
        sach.setTacGia(" ");
        assertFalse(sachService.suaSach(sach), "TC 7: Validate tác giả để trống => false");
    }
}