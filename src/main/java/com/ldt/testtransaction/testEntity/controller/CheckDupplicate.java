package com.ldt.testtransaction.testEntity.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CheckDupplicate {

    public static void main(String[] args) {
                    String services[] = new String[]{
            "/api/admin-portal/crm/enterprise-mgmt/update/update-enterprise-change-email-account" ,
                "/api/admin-portal/affiliate/member/convert" ,
                "/api/admin-portal/bill-affiliate-commission/get-popup" ,
                "/api/admin-portal/bill-affiliate-commission/get-combobox" ,
                "/api/admin-portal/bill-affiliate-commission/update/commission-config-min" ,
                "/api/admin-portal/bill-affiliate-commission/get/commission-config-min" ,
                "/api/admin-portal/affiliate-commission/get-combobox/pricing-and-combo-plan" ,
                "/api/admin-portal/affiliate-commission/check-user-condition-role" ,
                "/api/admin-portal/affiliate/member/check-referral" ,
                "/api/admin-portal/affiliate/member/change-status" ,
                "/api/admin-portal/affiliate/member/update-profile" ,
                "/api/admin-portal/affiliate/member/resend-info" ,
                "/api/admin-portal/affiliate/member/register" ,
                "/api/admin-portal/affiliate-link/get-commission-success" ,
                "/api/admin-portal/affiliate-link/check-config-edit-affiliate-link" ,
                "/api/admin-portal/affiliate-commission/check-config-edit-commision-link" ,
                "api/admin-portal/affiliate/member/test-commission" ,
                "/api/portal/attributes/overview/" ,
                "/api/portal/variant" ,
                "/api/portal/file/site-map" ,
                "/api/portal/integrate-services" ,
                "/api/sme-portal/combos" ,
                "/api/sme-portal/services" ,
                "/api/sme-portal/system-param/detail" ,
                "/api/portal/services/categories" ,
                "/api/portal/services-recommend" ,
                "/api/portal/rating/services" ,
                "/api/sme-portal/rating/services" ,
                "/login" ,
                "/swagger-ui" ,
                "/swagger-resources" ,
                "/api/v3" ,
                "/v3/api-docs" ,
                "/swagger-ui.html" ,
                "/resources" ,
                "/api-dev/integrate/" ,
                "/api/sme-portal/subscription/services/" ,
                "/api/dev-portal/services/create/application/step1" ,
                "/contacts" ,
                "/api/portal/pre-order" ,
                "/api/integration/dev-portal/setup/success" ,
                "/api/portal/massoffer/tracking" ,
                "/api/sme-portal/system-param/detail" ,
                "/api/sme-portal/seo/detail" ,
                "/api/sme-portal/seo/find-all" ,
                "/api/integration/portal/subscription/update-quantity" ,
                "/api/common/combobox" ,
                "/api/enterprise/email" ,
                "/api/enterprise/phone" ,
                "/api/enterprise/checkTin" ,
                "/api/enterprise/check-tin-and-user-status" ,
                "/api/enterprise/get-info-by-tin" ,
                "/api/enterprise/createEnterprise" ,
                "/api/enterprise/checkIdentify" ,
                "/api/sme-portal/page-builder" ,
                "/api/portal/payment/notification-receiver" ,
                "/api/portal/payment/verify" ,
                "/api/sme-portal/marketing-campaign/ads-action" ,
                "/api/sme-portal/marketing-campaign/get-list-available-popup" ,
                "/api/sme-portal/marketing-campaign/get-list-active-campaign" ,
                "/api/sme-portal/marketing-campaign/get-list-banner-on-services" ,
                "/api/sme-portal/marketing-campaign/get-campaign-detail" ,
                "/api/migration/user/active-imported" ,
                "/api/migration/user/new-password" ,
                "/api/portal/services/checkCanRemoveCustomerType" ,
                "/api/portal/pricing/checkCanRemoveCustomerType" ,
                "/api/tmdt/report" ,
                "/api/collect-info-preorder" ,
                "/api/update-info-preorder" ,
                "/api/sme-portal/shopping-cart/get-spdv-detail" ,
                "/api/sme-portal/shopping-cart/update-cart" ,
                "/api/sme-portal/shopping-cart/get-cart" ,
                "/api/sme-portal/shopping-cart/get-detail" ,
                "/api/portal/pricing/detail/" ,
                "/api/portal/subscription/pricing/coupon-mc-promotion" ,
                "/api/portal/subscription/combo-plan/coupon-mc-promotion" ,
                "/api/portal/subscription/addon/coupon-mc-promotion" ,
                "/api/portal/subscription/total/coupon-mc-promotion" ,
                "/api/portal/subscription/combo-plan/total/coupon-mc-promotion" ,
                "/api/sme-portal/shorten-link/detail" ,
                "/api/sme-portal/topic" ,
                "/api/dev-portal/subscription/pricing/bill-incurred-once" ,
                "/api/admin-portal/email-setting" ,
                "/api/portal/subscription/test-swap-auto" ,
                "/api/sme-portal/affiliate-link/statistical-click" ,
                "/api/admin-portal/system-param" ,
                "/api/dev-portal/reports/statistic-customer" ,
                "/api/dev-portal/reports/export-pricing-services" ,
                "/api/dev-portal/reports/statistic-revenue" ,
                "/api/portal/attributes/payment" ,
                "/api/portal/variant"
        };


        String auths[] = new String[]{
            "/business" ,
            "/api/users/countries" ,
            "/api/users-admin/affiliate" ,
            "/api/users-admin/register" ,
            "/api/users-sme/register" ,
            "/api/users-sme/verify-otp-activate" ,
            "/api/users-sme/resend-activation-mail" ,
            "/api/users-dev/register" ,
            "/login" ,
            "/sso" ,
            "/api/sme-users" ,
            "/oauth/token" ,
            "/oauth/refresh-token" ,
            "/oauth/token/revokeById" ,
            "/oauth2/callback" ,
            "/token/revoke" ,
            "/api/users/verify" ,
            "/reset-password" ,
            "/forgot-password" ,
            "/verify-otp-reset-password" ,
            "/swagger-ui" ,
            "/swagger-resources" ,
            "/api/v3" ,
            "/v3/api-docs" ,
            "/api/users/provinces" ,
            "/api/users/districts" ,
            "/api/users/business/areas" ,
            "/api/users/business/scale" ,
            "/swagger-ui.html" ,
            "/resources" ,
            "/api/users-sme/get-tax-code" ,
            "/api/users/ward/" ,
            "/api-dev/integrate/" ,
            "/api/users/change-password" ,
            "/folkes" ,
            "/api/integration/sme-employees" ,
            "/api/users-sme/otp-refresh" ,
            "/api/users-sme/otp-change-password" ,
            "/api/users-sme/otp-verify" ,
            "/api/users-sme/3rd-url-login-source" ,
            "/api/users-sme/3rd-urls-source" ,
            "/api/users-sme/update-registry-info" ,
            "/api/users-sme/employee/smes" ,
            "/oauth/login" ,
            "/sso/workplace" ,
            "/api/users-sme/send-otp" ,
            "/api/users-sme/resend-otp" ,
            "/workplace-validate-invitation-link" ,
            "/workplace-create-sme-employees" ,
            "/api/users-sme/send-notif-login-first-time" ,
            "/3rd-party/create-employee" ,
            "/3rd-party/update-employee"
        };

        String[] allEl = new String[]{
            "/3rd-party/**",
            "/actuator/**",
            "/actuator/**",
            "/api-dev/integrate/**",
            "/api-dev/integrate/**",
            "/api/admin-portal/affiliate-link/get-commission-success",
            "/api/admin-portal/affiliate-link/get-commission-success",
            "/api/admin-portal/affiliate/member/change-status",
            "/api/admin-portal/affiliate/member/change-status",
            "/api/admin-portal/affiliate/member/check-referral",
            "/api/admin-portal/affiliate/member/check-referral",
            "/api/admin-portal/affiliate/member/convert",
            "/api/admin-portal/affiliate/member/convert",
            "/api/admin-portal/affiliate/member/register",
            "/api/admin-portal/affiliate/member/register",
            "/api/admin-portal/affiliate/member/resend-info",
            "/api/admin-portal/affiliate/member/resend-info",
            "/api/admin-portal/affiliate/member/update-profile",
            "/api/admin-portal/affiliate/member/update-profile",
            "/api/admin-portal/crm/enterprise-mgmt/update/update-enterprise-change-email-account",
            "/api/admin-portal/crm/enterprise-mgmt/update/update-enterprise-change-email-account",
            "/api/admin-portal/system-param/**",
            "/api/admin-portal/system-param/**",
            "/api/collect-info-preorder",
            "/api/collect-info-preorder",
            "/api/enterprise/**",
            "/api/enterprise/**",
            "/api/integration/**",
            "/api/integration/**",
            "/api/migration/user/active-imported/{activationKey}",
            "/api/migration/user/active-imported/{activationKey}",
            "/api/migration/user/new-password/{id}",
            "/api/migration/user/new-password/{id}",
            "/api/permissions/get-all-permission-app",
            "/api/portal/attributes/overview/**",
            "/api/portal/attributes/payment/**",
            "/api/portal/attributes/payment/**",
            "/api/portal/file/site-map",
            "/api/portal/file/site-map",
            "/api/portal/integrate-service/**",
            "/api/portal/integrate-service/**",
            "/api/portal/pre-order",
            "/api/portal/pre-order",
            "/api/portal/pricing/detail/**",
            "/api/portal/seo/default",
            "/api/portal/seo/default",
            "/api/portal/variant/**",
            "/api/portal/variant/**",
            "/api/sme-portal/affiliate-link/statistical-click",
            "/api/sme-portal/affiliate-link/statistical-click",
            "/api/sme-portal/combos/**",
            "/api/sme-portal/combos/**",
            "/api/sme-portal/migration/**",
            "/api/sme-portal/migration/**",
            "/api/sme-portal/page-builder/**",
            "/api/sme-portal/page-builder/**",
            "/api/sme-portal/seo/detail",
            "/api/sme-portal/seo/detail",
            "/api/sme-portal/seo/find-all",
            "/api/sme-portal/seo/find-all",
            "/api/sme-portal/shopping-cart/get-cart",
            "/api/sme-portal/shopping-cart/get-cart",
            "/api/sme-portal/shopping-cart/get-detail",
            "/api/sme-portal/shopping-cart/get-detail",
            "/api/sme-portal/shopping-cart/get-spdv-detail",
            "/api/sme-portal/shopping-cart/get-spdv-detail",
            "/api/sme-portal/shopping-cart/update-cart",
            "/api/sme-portal/shopping-cart/update-cart",
            "/api/sme-portal/shorten-link/detail",
            "/api/sme-portal/shorten-link/detail",
            "/api/sme-portal/system-param/**",
            "/api/sme-portal/system-param/**",
            "/api/sme-portal/topic/**",
            "/api/sme-portal/topic/**",
            "/api/sme-users/**",
            "/api/tmdt/report",
            "/api/tmdt/report",
            "/api/update-info-preorder",
            "/api/update-info-preorder",
            "/api/user/**",
            "/api/users-dev/**",
            "/api/users-sme/**",
            "/api/users-sme/get-tax-code",
            "/api/users-sme/verify-otp-activate",
            "/api/users/{id}/reset-password/{resetToken},",
            "/api/users/business/areas/**",
            "/api/users/business/scale/**",
            "/api/users/countries/**",
            "/api/users/districts/**",
            "/api/users/forgot-password,",
            "/api/users/provinces/**",
            "/api/users/verify-otp-reset-password",
            "/api/users/verify/**,",
            "/api/users/ward/{id}/{code}/street",
            "/api/v1/partner/**",
            "/api/v3/**",
            "/api/v3/**",
            "/api/v3/**",
            "/api/v3/**",
            "/api/v3/**",
            "/auth/**,",
            "/login",
            "/oauth/login",
            "/oauth/login",
            "/oauth/refresh-token",
            "/oauth/token",
            "/oauth/token/revokeById/**",
            "/oauth2/**",
            "/resources/**",
            "/resources/**",
            "/resources/**",
            "/resources/**",
            "/sso/**",
            "/sso/verify",
            "/sso/workplace",
            "/swagger-resources/**",
            "/swagger-resources/**",
            "/swagger-resources/**, ",
            "/swagger-resources/**, ",
            "/swagger-resources/**\", \"/resources/**",
            "/swagger-ui.html",
            "/swagger-ui.html",
            "/swagger-ui.html",
            "/swagger-ui.html",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/swagger-ui/**",
            "/swagger-ui/**",
            "/swagger-ui/**",
            "/swagger-ui/**",
            "/token/remove",
            "/token/revoke,",
            "/v3/api-docs/**",
            "/v3/api-docs/**",
            "/v3/api-docs/**",
            "/v3/api-docs/**",
            "/v3/api-docs/**",
            "/verify-otp-login",
            "/verify-otp-login"
        };

        List<String> serNotInAuth = new ArrayList<>();
        List<String> dupplicate = new ArrayList<>();

        List<String> serInAuth = new ArrayList<>();
        Set<String> authSet = new LinkedHashSet<>();
        Set<String> allSet = new LinkedHashSet<>();
        for(String ser : auths){
            authSet.add(ser);
            allSet.add(ser);
        }
        for(String s : services){
            if(!authSet.contains(s)){
                serNotInAuth.add(s);
            }else{
                serInAuth.add(s);
                allSet.add(s);
            }
        }
//
//        System.out.println("----");
//        for(String s: serNotInAuth){
//            System.out.println(s);
//        }
//        System.out.println("----");
//        for(String s: serInAuth){
//            System.out.println(s);
//        }

        for(String el: allEl){
            if(allSet.contains(el)){
               dupplicate.add(el);
            }
        }

        System.out.println("---dupplicate---");
        for(String s: dupplicate){
            System.out.println(s);
        }


    }
}