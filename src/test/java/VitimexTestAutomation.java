import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VitimexTestAutomation {

    public static void main(String[] args) {
        // Đường dẫn đến ChromeDriver của bạn
        // LƯU Ý: Bạn cần tải ChromeDriver và thay thế đường dẫn này
        System.setProperty("webdriver.chrome.driver", "ĐƯỜNG_DẪN_ĐẾN_CHROMEDRIVER/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String url = "https://vitimex.com.vn/";
        String tenSanPhamCanTim = "Vải Thun"; // Sản phẩm cần tìm kiếm

        try {
            // 1. Mở trang web
            driver.get(url);
            driver.manage().window().maximize();
            System.out.println("Đã mở trang web thành công.");

            // --------------------------------------------------------
            // Yêu cầu 1: Tìm kiếm 1 sản phẩm trên ô tìm kiếm (1 Điểm)
            // --------------------------------------------------------

            // Xác định ô tìm kiếm (dựa trên class hoặc id của trang vitimex.com.vn)
            // Dùng XPath/CSS Selector để tìm ô có placeholder là "Tìm kiếm..."
            WebElement searchBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Tìm kiếm...']"))
            );

            // Nhập tên sản phẩm vào ô tìm kiếm
            searchBox.sendKeys(tenSanPhamCanTim);
            System.out.println("Đã nhập từ khóa: " + tenSanPhamCanTim);

            // Nhấn Enter để thực hiện tìm kiếm (hoặc click vào nút tìm kiếm nếu có)
            searchBox.submit();
            System.out.println("Đã thực hiện tìm kiếm.");

            // --------------------------------------------------------
            // Yêu cầu 2: Thực hiện việc thêm 1 sản phẩm vừa tìm vào giỏ hàng (1 Điểm)
            // --------------------------------------------------------

            // Chờ trang kết quả tìm kiếm tải xong
            // Tìm kiếm sản phẩm đầu tiên trong danh sách kết quả (dựa trên cấu trúc trang)

            // Xác định nút "Thêm vào giỏ hàng" hoặc "Mua hàng" cho sản phẩm đầu tiên
            // LƯU Ý: Selector này cần được kiểm tra lại nếu cấu trúc HTML của trang thay đổi.
            // Giả định nút "Thêm vào giỏ hàng" có class 'add_to_cart'
            By addToCartButtonSelector = By.xpath("(//a[contains(@class, 'add_to_cart') or text()='Thêm vào giỏ'])[1]");

            WebElement addToCartButton = wait.until(
                    ExpectedConditions.elementToBeClickable(addToCartButtonSelector)
            );

            // Click vào nút "Thêm vào giỏ hàng"
            addToCartButton.click();
            System.out.println("Đã thêm sản phẩm đầu tiên vào giỏ hàng.");

            // Optional: Chờ thông báo giỏ hàng hiện ra hoặc giỏ hàng cập nhật
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'cart-count') or text()='1']")));
            System.out.println("Giỏ hàng đã cập nhật thành công.");


        } catch (Exception e) {
            System.err.println("Xảy ra lỗi trong quá trình thực thi Selenium: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt sau khi hoàn thành
            // driver.quit();
            // Để dễ quan sát, tạm thời để trình duyệt mở 5 giây
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignored) {}
            driver.quit();
        }
    }
}