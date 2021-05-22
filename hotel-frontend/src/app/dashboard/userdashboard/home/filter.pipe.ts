import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterPipe',
})
export class filterPipe implements PipeTransform {
  transform(value: any[], city: any): any {
    //   console.log(city);
    console.log("value");
    let dataToSend = [];

    // if(value == null){
    //   return value;
    // }
    //  return value.filter(hotel => {
    //     console.log(hotel.city == city);
    //     if (hotel.city == city){
    //       return hotel;
    //     }else{
    //       return [];
    //     }
    //   })
    // for (let i = 0; i < city.length; i++) {
    //   for (let j = 0; j < value.length; j++) {
    //     if (city[i] == value[j].city) {
    //       dataToSend.push(value[j]);
    //     }
    //   }
    // }

    for (let i = 0; i < city.length; i++) {
      console.log(city[i]);
    }
    let my = value.filter((v) => city.includes(v.city));
    console.log('my');
    console.log(my);

    console.log(my); // for (let i = 0; i < value.length; i++) {
    //   console.log(value[i]);
    //   console.log('aala');
    // }
    // for (let i = 0; i < city.length; i++) {
    //   if(city[i] == value
    // }

    // return dataToSend;
    return my;
  }
}
