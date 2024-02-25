import {Component, OnInit} from '@angular/core';
import {SecurityService} from "./services/security.service";
import {KeycloakService} from "keycloak-angular";
import {KeycloakProfile} from "keycloak-js";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'Customer-angular';
  public profile? :KeycloakProfile;

  constructor(private keycloakService:KeycloakService) {
  }

  ngOnInit() {

    if(this.keycloakService.isLoggedIn()){
      this.keycloakService.loadUserProfile().then(profile=>{
        this.profile=profile;
      });
    }




  }

  async login() {
    await this.keycloakService.login({
      redirectUri: window.location.origin
    });
  }
  logout(){
    this.keycloakService.logout(window.location.origin)

  }


}
