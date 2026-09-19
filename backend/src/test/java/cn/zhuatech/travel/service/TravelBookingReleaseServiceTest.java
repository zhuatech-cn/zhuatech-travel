/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.travel.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class TravelBookingReleaseServiceTest {
    private final TravelBookingReleaseService service = new TravelBookingReleaseService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void releasesCompliantTravelBooking() {
        var result = service.assess(new TravelBookingReleaseService.Request("TR-100", true, true, true,
                true, true, false, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(TravelBookingReleaseService.Decision.BOOK);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void routesAdministrativeGapsToReview() {
        var result = service.assess(new TravelBookingReleaseService.Request("TR-101", false, true, true,
                false, true, false, true, false, false, false, true));
        assertThat(result.actions()).hasSize(5);
        assertThat(result.decision()).isEqualTo(TravelBookingReleaseService.Decision.REVIEW);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnsafeOrUnfundedTravel() {
        var result = service.assess(new TravelBookingReleaseService.Request("", false, false, false,
                false, false, true, false, false, false, false, false));
        assertThat(result.blockers()).hasSize(6);
        assertThat(result.decision()).isEqualTo(TravelBookingReleaseService.Decision.BLOCKED);
    }
}
