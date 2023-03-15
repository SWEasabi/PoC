import { Component, ChangeDetectionStrategy } from '@angular/core';
import { AppService } from '../app.service';
import { BehaviorSubject, first, tap, delay } from 'rxjs'
import { StatusData } from '../model';
import { switchMap } from 'rxjs/internal/operators/switchMap';
import { OnInit } from '@angular/core';
@Component({
  selector: 'app-lamp-button',
  templateUrl: './lamp-button.component.html',
  styleUrls: ['./lamp-button.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class LampButtonComponent implements OnInit {
  lampStatus$ = new BehaviorSubject<StatusData | null>(null);

  constructor(private service: AppService) { }

  ngOnInit(): void {
    this.getStatus();
  }


  toggleLamp() {
    this.lampStatus$.pipe(//switchMap operator
      first(),
      tap(() => {
        this.lampStatus$.next(null)
      }),
      switchMap((responseData) => this.service.toggleLamp$(responseData?.status))
    ).subscribe(() => this.getStatus())


  }
  getStatus() {
    this.service.getData$().pipe(
      delay(500)).subscribe((statusData) => {
        this.lampStatus$.next(statusData);
      })
  }
}
