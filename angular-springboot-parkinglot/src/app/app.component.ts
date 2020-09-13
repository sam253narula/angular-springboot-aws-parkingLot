import { Component, VERSION } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { take } from 'rxjs/operators';


@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  name = 'Angular ' + VERSION.major;

  response : any;

  constructor(private http:HttpClient) {
    // this.http.get('https://jsonplaceholder.typicode.com/posts')
    // .subscribe(response => {
    //   console.log(response);
    // })
    this.getAllParkingLotInfo();
  }

  // async getPost() {
  //   this.response = await this.http.get('https://jsonplaceholder.typicode.com/posts')
  //         .pipe(take(1))
  //         .toPromise();
  //   console.log(this.response);
  //   console.log("Hello");
  // }


    async getAllParkingLotInfo() {
    this.response =  await this.http.get('http://ec2-100-25-143-38.compute-1.amazonaws.com:8080/parkinglot/parkingInfo')
          .pipe(take(1))
          .toPromise();
    console.log(this.response);
    //console.log("Hello");
  }
  

}
