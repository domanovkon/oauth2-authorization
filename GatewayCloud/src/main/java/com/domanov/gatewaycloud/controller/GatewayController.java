package com.domanov.gatewaycloud.controller;

import com.domanov.gatewaycloud.dto.*;
import com.domanov.gatewaycloud.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("https://lab2-gateway-service.herokuapp.com/api/v1")
public class GatewayController {

    @Autowired
    GatewayService gatewayService;

    @GetMapping("api/v1/privilege")
    @CrossOrigin(origins = "*")
    public Object getBonusAccountPrivileges() {
        return gatewayService.getBonusAccountPrivileges();
    }

    @GetMapping(value = "api/v1/flights", params = {"page", "size"})
    @CrossOrigin(origins = "*")
    public Object getFlightsPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return gatewayService.findAll(page, size);
    }

    @PostMapping("api/v1/tickets")
    @CrossOrigin(origins = "*")
    public Object buyTicket(@RequestBody FlightBuyRequest flightBuyRequest) {
        return gatewayService.buyTicket(flightBuyRequest);
    }

    @GetMapping("api/v1/tickets/{ticketUid}")
    @CrossOrigin(origins = "*")
    public Object getTicket(@PathVariable(value = "ticketUid") UUID ticketUid) {
        return gatewayService.getTicket(ticketUid);
    }

    @GetMapping("api/v1/tickets")
    @CrossOrigin(origins = "*")
    public Object getTickets() {
        return gatewayService.getTickets();
    }

    @GetMapping("api/v1/me")
    @CrossOrigin(origins = "*")
    public Object getUser() {
        return gatewayService.getUser();
    }

    @DeleteMapping("api/v1/tickets/{ticketUid}")
    @CrossOrigin(origins = "*")
    public Object ticketCancel(@PathVariable(value = "ticketUid") UUID ticketUid) {
        return gatewayService.ticketCancel(ticketUid);
    }
}
