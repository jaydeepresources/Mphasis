import { Status } from './model/Status';
import { PostsService } from './posts.service';
import { Post } from './model/Post';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  progressFlag: boolean

  constructor(public service: PostsService) {
    this.progressFlag = true
    service.getPosts().subscribe((data: Post[]) => {
      this.service.posts = data
      this.progressFlag = false
    })
  }

  delete(id:number,i: number){
    this.service.deletePost(id)
    .subscribe((data:Status) => {
      if(data.queryStatus){
        this.service.posts.splice(i,1)
      }
    })
  }

}