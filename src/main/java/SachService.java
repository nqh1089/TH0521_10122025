public class SachService {

    public boolean suaSach(Sach sach) {
        // --- 1. Validate: Các trường String không được để trống (Implicit/Tối thiểu) ---
        if (sach.getMaSach() == null || sach.getMaSach().trim().isEmpty() ||
                sach.getTenSach() == null || sach.getTenSach().trim().isEmpty() ||
                sach.getTacGia() == null || sach.getTacGia().trim().isEmpty()) {

            // Log: "Dữ liệu bắt buộc (String fields) không được để trống."
            return false;
        }

        // --- 2. Validate: namXuatBan phải trong khoảng [1990, 2025] (2 Điểm) ---
        int namXB = sach.getNamXuatBan();

        // Kiểm tra phân vùng hợp lệ: 1990 <= namXB <= 2025
        if (namXB >= 1990 && namXB <= 2025) {
            // Logic sửa sách thực tế (ví dụ: gọi repository.update(sach))
            // Giả sử sửa thành công nếu Validation pass
            return true;
        } else {
            return false;
        }
    }
}