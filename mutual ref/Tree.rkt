;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname Tree) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #t)))

; (@htdd Node ListOfNode)
(define-struct node (val childrens))
;; Node is (make-node val ListOfNode)
;; interp. ...

;; ListOfNode is one of:
;; - empty
;; - (cons Node ListOfNode)


(define N1 (make-node 1 empty))
(define N2 (make-node 2 empty))
(define N3 (make-node 3 empty))
(define N4 (make-node 4 empty))
(define N5 (make-node 5 empty))
(define N7 (make-node 7 empty))

(define T1 (make-node 1 (list N2 N7)))

(define T2 (make-node 4 (list T1 N3 N5)))



(define (sum--node n)
  (+ (node-val n) (sum--lon (node-childrens n))))

(define (sum--lon lon)
  (cond [(empty? lon) 0]
        [else
         (+ (sum--node (first lon))
            (sum--lon (rest lon)))
            ]
        ))

(sum--node T2)


(define (greater-than--node n)
       (if (< 3 (node-val n))
           (cons (node-val n)
                 (greater-than--lon (node-childrens n)))
           (greater-than--lon (node-childrens n))))

(define (greater-than--lon lon)
       (cond [(empty? lon) empty]
             [else
              (append (greater-than--node (first lon))
                      (greater-than--lon (rest lon))
                      )
              ]
             ))
             
(greater-than--node T2)








