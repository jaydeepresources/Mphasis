import { Status } from './../model/Status';
import { AuthenticateService } from './../authenticate.service';
import { Comment } from './../model/Comment';
import { CommentsService } from './../comments.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input()
  postId: number

  comment: Comment
  comments: Comment[]
  progressFlag: boolean
  clickedCounter: number

  constructor(public commentsService: CommentsService, public authService: AuthenticateService) {
    this.initComment()
    this.comments = []
    this.clickedCounter = 0
  }

  initComment() {
    this.comment = {
      commentId: 0,
      commentText: '',
      fk: 0,
      ufk: 0
    }
  }

  ngOnInit() {
  }

  getComments() {
    this.progressFlag = true
    this.clickedCounter++

    if (this.clickedCounter > 1) {
      this.progressFlag = false
      return
    }

    this.commentsService.getComments(this.postId)
      .subscribe((res: Comment[]) => {
        if (res) {
          this.comments = res
        }

        this.progressFlag = false

      })
  }

  addComment(addCommentForm) {
    this.comment.fk = this.postId
    this.comment.ufk = this.authService.currentUser.id

    this.commentsService.addComment(this.comment)
      .subscribe((res: Comment) => {
        this.comments.push(res)
        this.initComment()
        addCommentForm.form.markAsPristine()
      })
  }

  deleteComment(commentId, index) {
    this.commentsService.deleteComment(commentId)
      .subscribe((res: Status) => {
        if (res.queryStatus)
          this.comments.splice(index, 1)
      })
  }

}
